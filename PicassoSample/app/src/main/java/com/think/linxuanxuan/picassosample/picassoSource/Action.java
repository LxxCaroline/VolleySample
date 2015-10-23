package com.think.linxuanxuan.picassosample.picassoSource;
/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import static com.think.linxuanxuan.picassosample.picassoSource.Picasso.Priority;

/*
 * Action代表了一个具体的加载任务，主要用于图片加载后的结果回调
 * 有两个抽象方法，complete和error，也就是当图片解析为bitmap后用户希望做什么。
 * 最简单的就是将bitmap设置给ImageView，失败了就将错误通过回调通知到上层。
 */
abstract class Action<T> {
    //弱引用，传入队列和action
    static class RequestWeakReference<M> extends WeakReference<M> {
        final Action action;

        public RequestWeakReference(Action action, M referent, ReferenceQueue<? super M> q) {
            super(referent, q);
            this.action = action;
        }
    }

    final Picasso picasso;
    //对图形的操作说明都在这个类中存储
    final Request request;
    final WeakReference<T> target;
    final boolean noFade;
    //记录memoryPolicy，分别有NO_CACHE(处理请求不查找缓存)和NO_STORE(不存储结果到缓存中)
    final int memoryPolicy;
    //记录networkPolicy，分别有NO_CACHE(不检查缓存直接访问网络)、NO_STORE(不存储)、OFFLINE(只检查缓存不走网络)
    final int networkPolicy;
    //错误资源的id和drawable
    final int errorResId;
    final Drawable errorDrawable;
    final String key;
    //就是自己
    final Object tag;

    boolean willReplay;
    //记录action是否被取消，true为被取消
    boolean cancelled;

    Action(Picasso picasso, T target, Request request, int memoryPolicy, int networkPolicy, int errorResId, Drawable errorDrawable, String key, Object tag, boolean noFade) {
        this.picasso = picasso;
        this.request = request;
        this.target = target == null ? null : new RequestWeakReference<T>(this, target, picasso.referenceQueue);
        this.memoryPolicy = memoryPolicy;
        this.networkPolicy = networkPolicy;
        this.noFade = noFade;
        this.errorResId = errorResId;
        this.errorDrawable = errorDrawable;
        this.key = key;
        this.tag = (tag != null ? tag : this);
    }

    //当得到bitmap会调用该函数
    abstract void complete(Bitmap result, Picasso.LoadedFrom from);

    //当未得到bitmap会调用该函数
    abstract void error();

    void cancel() {
        cancelled = true;
    }

    Request getRequest() {
        return request;
    }

    T getTarget() {
        return target == null ? null : target.get();
    }

    String getKey() {
        return key;
    }

    boolean isCancelled() {
        return cancelled;
    }

    boolean willReplay() {
        return willReplay;
    }

    int getMemoryPolicy() {
        return memoryPolicy;
    }

    int getNetworkPolicy() {
        return networkPolicy;
    }

    Picasso getPicasso() {
        return picasso;
    }

    Priority getPriority() {
        return request.priority;
    }

    Object getTag() {
        return tag;
    }
}
