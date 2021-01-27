package com.soran.nutshop.adapters;

import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class SliderAdapter  extends ss.com.bannerslider.adapters.SliderAdapter {
    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        switch (position) {
            case 0:
                imageSlideViewHolder.bindImageSlide("https://cdn2.vectorstock.com/i/1000x1000/69/21/kernels-nuts-for-badge-or-banner-vector-17706921.jpg");
                break;
            case 1:
                imageSlideViewHolder.bindImageSlide("https://leftcoastorganics.com/wp-content/uploads/2017/11/banner-nuts.jpg");
                break;
            case 2:
                imageSlideViewHolder.bindImageSlide("https://previews.123rf.com/images/margouillat/margouillat1611/margouillat161100853/66137051-banner-nuts.jpg");
                break;
            case 3:
                imageSlideViewHolder.bindImageSlide("https://thumbs.dreamstime.com/z/pile-nuts-shop-sign-market-banner-store-sign-vegetarian-restaurant-badge-healthy-nutrition-vegan-eating-100755854.jpg");
        }

    }
}
