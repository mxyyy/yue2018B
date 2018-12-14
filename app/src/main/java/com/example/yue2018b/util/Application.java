package com.example.yue2018b.util;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Frecso磁盘缓存路径
        DiskCacheConfig.Builder builder = DiskCacheConfig.newBuilder(this);
        builder.setBaseDirectoryPath(getCacheDir());
        DiskCacheConfig diskCacheConfig = builder.build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,config);
    }
}
