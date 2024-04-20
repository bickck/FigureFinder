package com.find.figurefinder.common;

public class FigureSiteInfo {

    public static final String AMIAMIJP = "AmiAmiJP";
    public static final String AMIAMIEN = "AmiAmiEN";
    public static final String COMICSART = "ComicsArt";
    public static final String MANIAHOUSE = "MANIAHOUSE";
    public static final String FIGURESALIER = "FigureSaliler";
    public static final String RABBIT = "Rabbits";
    public static final String FIGUREPRESSO = "FigurePresso";
    public static final String HEROTIME = "HeroTime";

    public class AmiAmiJP {
        public static final String PRODUCT_LIST_QUERY = "product_table_list";
        public static final String PRODUCT_NAME_QUERY = ".product_box > a > .product_name > .product_name_inner";
        public static final String PRODUCT_IMAGE_QUERY = ".product_box > a > .product_img > img ";
        public static final String PRODUCT_PRICE_QUERY = ".product_box > a > .product_price";
        public static final String PRODUCT_BRAND_QUERY = "";
    }

    public class AmiAmiEN {
        public static final String PRODUCT_LIST_QUERY = "new-items__inner";
        public static final String PRODUCT_NAME_QUERY = "newly-added-items__item__name";
        public static final String PRODUCT_IMAGE_QUERY = "newly-added-items__item__image_item";
        public static final String PRODUCT_PRICE_QUERY = "newly-added-items__item__price";
        public static final String PRODUCT_BRAND_QUERY = "newly-added-items__item__brand";
    }

    public class ComicsArt {
        public static final String PRODUCT_LIST_QUERY = "prdList grid8";
        public static final String PRODUCT_NAME_QUERY = ".name > a > span";
        public static final String PRODUCT_PRICE_QUERY = ".description > ul > xans-record- halfli2 > span";
        public static final String PRODUCT_IMAGE_QUERY = ".description > ul > xans-record- > span";
        public static final String PRODUCT_BRAND_QUERY = ".thumbnail > .prdImg > a > img";
    }

    public class ManiaHouse {
        public static final String PRODUCT_LIST_QUERY = "new-items__inner";
        public static final String PRODUCT_NAME_QUERY = "newly-added-items__item__name";
        public static final String PRODUCT_IMAGE_QUERY = "newly-added-items__item__image_item";
        public static final String PRODUCT_PRICE_QUERY = "newly-added-items__item__price";
        public static final String PRODUCT_BRAND_QUERY = "newly-added-items__item__brand";
    }

    public class FigureSaliler {
        public static final String PRODUCT_LIST_QUERY = "";
        public static final String PRODUCT_NAME_QUERY = "";
        public static final String PRODUCT_IMAGE_QUERY = "";
        public static final String PRODUCT_PRICE_QUERY = "";
        public static final String PRODUCT_BRAND_QUERY = "";
    }

    public class Rabbits {
        public static final String PRODUCT_LIST_QUERY = "";
        public static final String PRODUCT_NAME_QUERY = "";
        public static final String PRODUCT_IMAGE_QUERY = "";
        public static final String PRODUCT_PRICE_QUERY = "";
        public static final String PRODUCT_BRAND_QUERY = "";
    }

    public class FigurePresso {
        public static final String PRODUCT_LIST_QUERY = "";
        public static final String PRODUCT_NAME_QUERY = "";
        public static final String PRODUCT_IMAGE_QUERY = "";
        public static final String PRODUCT_PRICE_QUERY = "";
        public static final String PRODUCT_BRAND_QUERY = "";
    }

    public class HeroTime {
        public static final String PRODUCT_LIST_QUERY = "";
        public static final String PRODUCT_NAME_QUERY = "";
        public static final String PRODUCT_IMAGE_QUERY = "";
        public static final String PRODUCT_PRICE_QUERY = "";
        public static final String PRODUCT_BRAND_QUERY = "";
    }
}
