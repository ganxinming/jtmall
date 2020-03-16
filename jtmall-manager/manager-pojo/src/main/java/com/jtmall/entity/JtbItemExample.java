package com.jtmall.entity;

import java.util.ArrayList;
import java.util.List;

public class JtbItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JtbItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLititleIsNull() {
            addCriterion("lititle is null");
            return (Criteria) this;
        }

        public Criteria andLititleIsNotNull() {
            addCriterion("lititle is not null");
            return (Criteria) this;
        }

        public Criteria andLititleEqualTo(String value) {
            addCriterion("lititle =", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleNotEqualTo(String value) {
            addCriterion("lititle <>", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleGreaterThan(String value) {
            addCriterion("lititle >", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleGreaterThanOrEqualTo(String value) {
            addCriterion("lititle >=", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleLessThan(String value) {
            addCriterion("lititle <", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleLessThanOrEqualTo(String value) {
            addCriterion("lititle <=", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleLike(String value) {
            addCriterion("lititle like", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleNotLike(String value) {
            addCriterion("lititle not like", value, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleIn(List<String> values) {
            addCriterion("lititle in", values, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleNotIn(List<String> values) {
            addCriterion("lititle not in", values, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleBetween(String value1, String value2) {
            addCriterion("lititle between", value1, value2, "lititle");
            return (Criteria) this;
        }

        public Criteria andLititleNotBetween(String value1, String value2) {
            addCriterion("lititle not between", value1, value2, "lititle");
            return (Criteria) this;
        }

        public Criteria andCNumberIsNull() {
            addCriterion("c_number is null");
            return (Criteria) this;
        }

        public Criteria andCNumberIsNotNull() {
            addCriterion("c_number is not null");
            return (Criteria) this;
        }

        public Criteria andCNumberEqualTo(Integer value) {
            addCriterion("c_number =", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberNotEqualTo(Integer value) {
            addCriterion("c_number <>", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberGreaterThan(Integer value) {
            addCriterion("c_number >", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_number >=", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberLessThan(Integer value) {
            addCriterion("c_number <", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberLessThanOrEqualTo(Integer value) {
            addCriterion("c_number <=", value, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberIn(List<Integer> values) {
            addCriterion("c_number in", values, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberNotIn(List<Integer> values) {
            addCriterion("c_number not in", values, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberBetween(Integer value1, Integer value2) {
            addCriterion("c_number between", value1, value2, "cNumber");
            return (Criteria) this;
        }

        public Criteria andCNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("c_number not between", value1, value2, "cNumber");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Float value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Float value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Float value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Float value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Float value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Float value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Float> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Float> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Float value1, Float value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Float value1, Float value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andOrignPriceIsNull() {
            addCriterion("orign_price is null");
            return (Criteria) this;
        }

        public Criteria andOrignPriceIsNotNull() {
            addCriterion("orign_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrignPriceEqualTo(Float value) {
            addCriterion("orign_price =", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceNotEqualTo(Float value) {
            addCriterion("orign_price <>", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceGreaterThan(Float value) {
            addCriterion("orign_price >", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("orign_price >=", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceLessThan(Float value) {
            addCriterion("orign_price <", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceLessThanOrEqualTo(Float value) {
            addCriterion("orign_price <=", value, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceIn(List<Float> values) {
            addCriterion("orign_price in", values, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceNotIn(List<Float> values) {
            addCriterion("orign_price not in", values, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceBetween(Float value1, Float value2) {
            addCriterion("orign_price between", value1, value2, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andOrignPriceNotBetween(Float value1, Float value2) {
            addCriterion("orign_price not between", value1, value2, "orignPrice");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("key_word is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("key_word is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("key_word =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("key_word <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("key_word >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("key_word >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("key_word <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("key_word <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("key_word like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("key_word not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("key_word in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("key_word not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("key_word between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("key_word not between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNull() {
            addCriterion("audit_state is null");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNotNull() {
            addCriterion("audit_state is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStateEqualTo(String value) {
            addCriterion("audit_state =", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotEqualTo(String value) {
            addCriterion("audit_state <>", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThan(String value) {
            addCriterion("audit_state >", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThanOrEqualTo(String value) {
            addCriterion("audit_state >=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThan(String value) {
            addCriterion("audit_state <", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThanOrEqualTo(String value) {
            addCriterion("audit_state <=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLike(String value) {
            addCriterion("audit_state like", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotLike(String value) {
            addCriterion("audit_state not like", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateIn(List<String> values) {
            addCriterion("audit_state in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotIn(List<String> values) {
            addCriterion("audit_state not in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateBetween(String value1, String value2) {
            addCriterion("audit_state between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotBetween(String value1, String value2) {
            addCriterion("audit_state not between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}