package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class PageData {

    /**
     * code : 0
     * data : {"products":[{"category_id":11,"current_sku":{"discount":13,"id":10359878,"list_price":{"CNY":6299},"real_price":{"CNY":5500},"stock":6},"fav_count":3,"favorite":false,"id":10359878,"images":[{"h":800,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg","w":800}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"SPC PURU泪袋 眼膜","product_id":10359878,"rank":0,"review_count":0,"score":8,"sku_id":10359878,"url":"https://mcn.seashellmall.com/product/SPC-PURU%E6%B3%AA%E8%A2%8B-%E7%9C%BC%E8%86%9C-p-10359878.html"},{"category_id":10,"current_sku":{"discount":16,"id":10360592,"list_price":{"CNY":35000},"real_price":{"CNY":29500},"stock":7},"fav_count":0,"favorite":false,"id":10360549,"images":[{"h":290,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/d219f36f49874442a28ece2be0df2412.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/d219f36f49874442a28ece2be0df2412.jpg","w":290}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"ysl ROUGE VOLUPTÉ SHINE 金管 亮彩唇膏 42号新色！","product_id":10360549,"rank":0,"review_count":0,"score":8,"sku_id":10360592,"url":"https://mcn.seashellmall.com/product/ysl-ROUGE-VOLUPT%C3%89-SHINE-%E9%87%91%E7%AE%A1-%E4%BA%AE%E5%BD%A9%E5%94%87%E8%86%8F-42%E5%8F%B7%E6%96%B0%E8%89%B2%EF%BC%81-p-10360549.html"},{"category_id":13,"current_sku":{"discount":37,"id":10360586,"list_price":{"CNY":6000},"real_price":{"CNY":3800},"stock":8},"fav_count":0,"favorite":false,"id":10360543,"images":[{"h":255,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/efbdb6b828b24d7f825b28fffdc802f5.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/efbdb6b828b24d7f825b28fffdc802f5.jpg","w":255}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Kose 高丝 Q10护手霜                      (红色 超滋润型）","product_id":10360543,"rank":0,"review_count":0,"score":8,"sku_id":10360586,"url":"https://mcn.seashellmall.com/product/Kose-%E9%AB%98%E4%B8%9D-Q10%E6%8A%A4%E6%89%8B%E9%9C%9C----------------------%28%E7%BA%A2%E8%89%B2-%E8%B6%85%E6%BB%8B%E6%B6%A6%E5%9E%8B%EF%BC%89-p-10360543.html"},{"category_id":19,"current_sku":{"discount":12,"id":10360005,"list_price":{"CNY":10500},"real_price":{"CNY":9300},"stock":199},"fav_count":3,"favorite":false,"id":10360005,"images":[{"h":3456,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/0a1b0cb76ec84a67a7e21eaa756b76f7.JPG?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/0a1b0cb76ec84a67a7e21eaa756b76f7.JPG","w":2786}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Shiseido 资生堂 131 粉底刷","product_id":10360005,"rank":0,"review_count":0,"score":8,"sku_id":10360005,"url":"https://mcn.seashellmall.com/product/Shiseido-%E8%B5%84%E7%94%9F%E5%A0%82-131-%E7%B2%89%E5%BA%95%E5%88%B7-p-10360005.html"},{"category_id":37,"current_sku":{"discount":17,"id":10359960,"list_price":{"CNY":30520},"real_price":{"CNY":25450},"stock":200},"fav_count":2,"favorite":false,"id":10359960,"images":[{"h":2482,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/918a80e0b3ba4d53accd62afc6552b5b.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/918a80e0b3ba4d53accd62afc6552b5b.jpg","w":3149}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Laduree Face Color Rose Laduree花瓣腮红 [盒子]","product_id":10359960,"rank":0,"review_count":0,"score":8,"sku_id":10359960,"url":"https://mcn.seashellmall.com/product/Laduree-Face-Color-Rose-Laduree%E8%8A%B1%E7%93%A3%E8%85%AE%E7%BA%A2-%5B%E7%9B%92%E5%AD%90%5D-p-10359960.html"},{"category_id":37,"current_sku":{"discount":16,"id":10360704,"list_price":{"CNY":63979},"real_price":{"CNY":53800},"stock":200},"fav_count":4,"favorite":false,"id":10359958,"images":[{"h":440,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/ebf6b0bc3064483caa2458b3f7f722da.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/ebf6b0bc3064483caa2458b3f7f722da.jpg","w":440}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Laduree Face Color Rose Laduree花瓣腮红（3色入）粉芯","product_id":10359958,"rank":0,"review_count":0,"score":8,"sku_id":10360704,"url":"https://mcn.seashellmall.com/product/Laduree-Face-Color-Rose-Laduree%E8%8A%B1%E7%93%A3%E8%85%AE%E7%BA%A2%EF%BC%883%E8%89%B2%E5%85%A5%EF%BC%89%E7%B2%89%E8%8A%AF-p-10359958.html"},{"category_id":13,"current_sku":{"discount":27,"id":10359946,"list_price":{"CNY":5180},"real_price":{"CNY":3800},"stock":8},"fav_count":5,"favorite":false,"id":10359946,"images":[{"h":800,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/4bdaaf60be734132a2cdc1755a31f0b3.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/4bdaaf60be734132a2cdc1755a31f0b3.jpg","w":800}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Kose 高丝 Q10护手霜              ","product_id":10359946,"rank":0,"review_count":0,"score":8,"sku_id":10359946,"url":"https://mcn.seashellmall.com/product/Kose-%E9%AB%98%E4%B8%9D-Q10%E6%8A%A4%E6%89%8B%E9%9C%9C---------------p-10359946.html"},{"category_id":9,"current_sku":{"discount":26,"id":10360731,"list_price":{"CNY":26000},"real_price":{"CNY":19300},"stock":111},"fav_count":2,"favorite":false,"id":10359919,"images":[{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/ccaea6e960f24d86b02b1a507c4749b6.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/ccaea6e960f24d86b02b1a507c4749b6.jpg","w":1242}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"HABA SQ 鲨烷精纯美容油 15ml/30ml/60ml","product_id":10359919,"rank":0,"review_count":0,"score":8,"sku_id":10360731,"url":"https://mcn.seashellmall.com/product/HABA-SQ-%E9%B2%A8%E7%83%B7%E7%B2%BE%E7%BA%AF%E7%BE%8E%E5%AE%B9%E6%B2%B9-15ml-30ml-60ml-p-10359919.html"},{"category_id":6,"current_sku":{"discount":15,"id":10359896,"list_price":{"CNY":28279},"real_price":{"CNY":24200},"stock":200},"fav_count":1,"favorite":false,"id":10359896,"images":[{"h":800,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/de83f4bd10b94723b0c8892704938485.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/de83f4bd10b94723b0c8892704938485.jpg","w":800}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"RMK 玫瑰卸妆膏","product_id":10359896,"rank":0,"review_count":0,"score":8,"sku_id":10359896,"url":"https://mcn.seashellmall.com/product/RMK-%E7%8E%AB%E7%91%B0%E5%8D%B8%E5%A6%86%E8%86%8F-p-10359896.html"},{"category_id":11,"current_sku":{"discount":12,"id":10359879,"list_price":{"CNY":7419},"real_price":{"CNY":6600},"stock":200},"fav_count":2,"favorite":false,"id":10359879,"images":[{"h":800,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/f7255b7372474d518c1243023976ca08.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/f7255b7372474d518c1243023976ca08.jpg","w":516}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"Utena 佑天兰顶级W玻尿酸保湿 弹力面膜 一盒3片","product_id":10359879,"rank":0,"review_count":0,"score":8,"sku_id":10359879,"url":"https://mcn.seashellmall.com/product/Utena-%E4%BD%91%E5%A4%A9%E5%85%B0%E9%A1%B6%E7%BA%A7W%E7%8E%BB%E5%B0%BF%E9%85%B8%E4%BF%9D%E6%B9%BF-%E5%BC%B9%E5%8A%9B%E9%9D%A2%E8%86%9C-%E4%B8%80%E7%9B%923%E7%89%87-p-10359879.html"},{"category_id":12,"current_sku":{"discount":29,"id":10360604,"list_price":{"CNY":38600},"real_price":{"CNY":27592},"stock":94},"fav_count":10,"favorite":false,"id":10360561,"images":[{"h":320,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/4c501223acec4b29aa38dd39e6cd0300.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/4c501223acec4b29aa38dd39e6cd0300.jpg","w":320}],"like_count":0,"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"merchant_id":84843049,"name":"pola 粉色 高保濕限定套裝","product_id":10360561,"rank":0,"review_count":0,"score":8,"sku_id":10360604,"url":"https://mcn.seashellmall.com/product/pola-%E7%B2%89%E8%89%B2-%E9%AB%98%E4%BF%9D%E6%BF%95%E9%99%90%E5%AE%9A%E5%A5%97%E8%A3%9D-p-10360561.html"}]}
     * success : true
     */

    private int code;
    private DataBean data;
    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {
        /**
         * category_id : 11
         * current_sku : {"discount":13,"id":10359878,"list_price":{"CNY":6299},"real_price":{"CNY":5500},"stock":6}
         * fav_count : 3
         * favorite : false
         * id : 10359878
         * images : [{"h":800,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg","w":800}]
         * like_count : 0
         * location : 日本
         * merchant : {"id":84843049,"name":"海呗自营","score":8}
         * merchant_id : 84843049
         * name : SPC PURU泪袋 眼膜
         * product_id : 10359878
         * rank : 0
         * review_count : 0
         * score : 8
         * sku_id : 10359878
         * url : https://mcn.seashellmall.com/product/SPC-PURU%E6%B3%AA%E8%A2%8B-%E7%9C%BC%E8%86%9C-p-10359878.html
         */

        private List<ProductsBean> products;

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            private int category_id;
            /**
             * discount : 13
             * id : 10359878
             * list_price : {"CNY":6299}
             * real_price : {"CNY":5500}
             * stock : 6
             */

            private CurrentSkuBean current_sku;
            private int fav_count;
            private boolean favorite;
            private int id;
            private int like_count;
            private String location;
            /**
             * id : 84843049
             * name : 海呗自营
             * score : 8
             */

            private MerchantBean merchant;
            private int merchant_id;
            private String name;
            private int product_id;
            private int rank;
            private int review_count;
            private int score;
            private int sku_id;
            private String url;
            /**
             * h : 800
             * t_h : 256
             * t_w : 256
             * thumb : http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg?iopcmd=thumbnail&type=8&width=256&height=256
             * url : http://ec-img.ufile.ucloud.cn/3db8acc2121942538aac28df268c2181.jpg
             * w : 800
             */

            private List<ImagesBean> images;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public CurrentSkuBean getCurrent_sku() {
                return current_sku;
            }

            public void setCurrent_sku(CurrentSkuBean current_sku) {
                this.current_sku = current_sku;
            }

            public int getFav_count() {
                return fav_count;
            }

            public void setFav_count(int fav_count) {
                this.fav_count = fav_count;
            }

            public boolean isFavorite() {
                return favorite;
            }

            public void setFavorite(boolean favorite) {
                this.favorite = favorite;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public MerchantBean getMerchant() {
                return merchant;
            }

            public void setMerchant(MerchantBean merchant) {
                this.merchant = merchant;
            }

            public int getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(int merchant_id) {
                this.merchant_id = merchant_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getProduct_id() {
                return product_id;
            }

            public void setProduct_id(int product_id) {
                this.product_id = product_id;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getReview_count() {
                return review_count;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getSku_id() {
                return sku_id;
            }

            public void setSku_id(int sku_id) {
                this.sku_id = sku_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class CurrentSkuBean {
                private int discount;
                private int id;
                /**
                 * CNY : 6299
                 */

                private ListPriceBean list_price;
                /**
                 * CNY : 5500
                 */

                private RealPriceBean real_price;
                private int stock;

                public int getDiscount() {
                    return discount;
                }

                public void setDiscount(int discount) {
                    this.discount = discount;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public ListPriceBean getList_price() {
                    return list_price;
                }

                public void setList_price(ListPriceBean list_price) {
                    this.list_price = list_price;
                }

                public RealPriceBean getReal_price() {
                    return real_price;
                }

                public void setReal_price(RealPriceBean real_price) {
                    this.real_price = real_price;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public static class ListPriceBean {
                    private int CNY;

                    public int getCNY() {
                        return CNY;
                    }

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }
                }

                public static class RealPriceBean {
                    private int CNY;

                    public int getCNY() {
                        return CNY;
                    }

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }
                }
            }

            public static class MerchantBean {
                private int id;
                private String name;
                private int score;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }
            }

            public static class ImagesBean {
                private int h;
                private int t_h;
                private int t_w;
                private String thumb;
                private String url;
                private int w;

                public int getH() {
                    return h;
                }

                public void setH(int h) {
                    this.h = h;
                }

                public int getT_h() {
                    return t_h;
                }

                public void setT_h(int t_h) {
                    this.t_h = t_h;
                }

                public int getT_w() {
                    return t_w;
                }

                public void setT_w(int t_w) {
                    this.t_w = t_w;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getW() {
                    return w;
                }

                public void setW(int w) {
                    this.w = w;
                }
            }
        }
    }
}
