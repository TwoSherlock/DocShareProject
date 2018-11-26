package com.sm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleInfoExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNmIsNull() {
            addCriterion("ROLE_NM is null");
            return (Criteria) this;
        }

        public Criteria andRoleNmIsNotNull() {
            addCriterion("ROLE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNmEqualTo(String value) {
            addCriterion("ROLE_NM =", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmNotEqualTo(String value) {
            addCriterion("ROLE_NM <>", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmGreaterThan(String value) {
            addCriterion("ROLE_NM >", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NM >=", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmLessThan(String value) {
            addCriterion("ROLE_NM <", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NM <=", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmLike(String value) {
            addCriterion("ROLE_NM like", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmNotLike(String value) {
            addCriterion("ROLE_NM not like", value, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmIn(List<String> values) {
            addCriterion("ROLE_NM in", values, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmNotIn(List<String> values) {
            addCriterion("ROLE_NM not in", values, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmBetween(String value1, String value2) {
            addCriterion("ROLE_NM between", value1, value2, "roleNm");
            return (Criteria) this;
        }

        public Criteria andRoleNmNotBetween(String value1, String value2) {
            addCriterion("ROLE_NM not between", value1, value2, "roleNm");
            return (Criteria) this;
        }

        public Criteria andStIsNull() {
            addCriterion("ST is null");
            return (Criteria) this;
        }

        public Criteria andStIsNotNull() {
            addCriterion("ST is not null");
            return (Criteria) this;
        }

        public Criteria andStEqualTo(String value) {
            addCriterion("ST =", value, "st");
            return (Criteria) this;
        }

        public Criteria andStNotEqualTo(String value) {
            addCriterion("ST <>", value, "st");
            return (Criteria) this;
        }

        public Criteria andStGreaterThan(String value) {
            addCriterion("ST >", value, "st");
            return (Criteria) this;
        }

        public Criteria andStGreaterThanOrEqualTo(String value) {
            addCriterion("ST >=", value, "st");
            return (Criteria) this;
        }

        public Criteria andStLessThan(String value) {
            addCriterion("ST <", value, "st");
            return (Criteria) this;
        }

        public Criteria andStLessThanOrEqualTo(String value) {
            addCriterion("ST <=", value, "st");
            return (Criteria) this;
        }

        public Criteria andStLike(String value) {
            addCriterion("ST like", value, "st");
            return (Criteria) this;
        }

        public Criteria andStNotLike(String value) {
            addCriterion("ST not like", value, "st");
            return (Criteria) this;
        }

        public Criteria andStIn(List<String> values) {
            addCriterion("ST in", values, "st");
            return (Criteria) this;
        }

        public Criteria andStNotIn(List<String> values) {
            addCriterion("ST not in", values, "st");
            return (Criteria) this;
        }

        public Criteria andStBetween(String value1, String value2) {
            addCriterion("ST between", value1, value2, "st");
            return (Criteria) this;
        }

        public Criteria andStNotBetween(String value1, String value2) {
            addCriterion("ST not between", value1, value2, "st");
            return (Criteria) this;
        }

        public Criteria andCrtrIsNull() {
            addCriterion("CRTR is null");
            return (Criteria) this;
        }

        public Criteria andCrtrIsNotNull() {
            addCriterion("CRTR is not null");
            return (Criteria) this;
        }

        public Criteria andCrtrEqualTo(String value) {
            addCriterion("CRTR =", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrNotEqualTo(String value) {
            addCriterion("CRTR <>", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrGreaterThan(String value) {
            addCriterion("CRTR >", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrGreaterThanOrEqualTo(String value) {
            addCriterion("CRTR >=", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrLessThan(String value) {
            addCriterion("CRTR <", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrLessThanOrEqualTo(String value) {
            addCriterion("CRTR <=", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrLike(String value) {
            addCriterion("CRTR like", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrNotLike(String value) {
            addCriterion("CRTR not like", value, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrIn(List<String> values) {
            addCriterion("CRTR in", values, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrNotIn(List<String> values) {
            addCriterion("CRTR not in", values, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrBetween(String value1, String value2) {
            addCriterion("CRTR between", value1, value2, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtrNotBetween(String value1, String value2) {
            addCriterion("CRTR not between", value1, value2, "crtr");
            return (Criteria) this;
        }

        public Criteria andCrtmIsNull() {
            addCriterion("CRTM is null");
            return (Criteria) this;
        }

        public Criteria andCrtmIsNotNull() {
            addCriterion("CRTM is not null");
            return (Criteria) this;
        }

        public Criteria andCrtmEqualTo(Date value) {
            addCriterion("CRTM =", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotEqualTo(Date value) {
            addCriterion("CRTM <>", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmGreaterThan(Date value) {
            addCriterion("CRTM >", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmGreaterThanOrEqualTo(Date value) {
            addCriterion("CRTM >=", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmLessThan(Date value) {
            addCriterion("CRTM <", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmLessThanOrEqualTo(Date value) {
            addCriterion("CRTM <=", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmIn(List<Date> values) {
            addCriterion("CRTM in", values, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotIn(List<Date> values) {
            addCriterion("CRTM not in", values, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmBetween(Date value1, Date value2) {
            addCriterion("CRTM between", value1, value2, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotBetween(Date value1, Date value2) {
            addCriterion("CRTM not between", value1, value2, "crtm");
            return (Criteria) this;
        }

        public Criteria andUpdtrIsNull() {
            addCriterion("UPDTR is null");
            return (Criteria) this;
        }

        public Criteria andUpdtrIsNotNull() {
            addCriterion("UPDTR is not null");
            return (Criteria) this;
        }

        public Criteria andUpdtrEqualTo(String value) {
            addCriterion("UPDTR =", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrNotEqualTo(String value) {
            addCriterion("UPDTR <>", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrGreaterThan(String value) {
            addCriterion("UPDTR >", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrGreaterThanOrEqualTo(String value) {
            addCriterion("UPDTR >=", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrLessThan(String value) {
            addCriterion("UPDTR <", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrLessThanOrEqualTo(String value) {
            addCriterion("UPDTR <=", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrLike(String value) {
            addCriterion("UPDTR like", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrNotLike(String value) {
            addCriterion("UPDTR not like", value, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrIn(List<String> values) {
            addCriterion("UPDTR in", values, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrNotIn(List<String> values) {
            addCriterion("UPDTR not in", values, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrBetween(String value1, String value2) {
            addCriterion("UPDTR between", value1, value2, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtrNotBetween(String value1, String value2) {
            addCriterion("UPDTR not between", value1, value2, "updtr");
            return (Criteria) this;
        }

        public Criteria andUpdtmIsNull() {
            addCriterion("UPDTM is null");
            return (Criteria) this;
        }

        public Criteria andUpdtmIsNotNull() {
            addCriterion("UPDTM is not null");
            return (Criteria) this;
        }

        public Criteria andUpdtmEqualTo(Date value) {
            addCriterion("UPDTM =", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmNotEqualTo(Date value) {
            addCriterion("UPDTM <>", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmGreaterThan(Date value) {
            addCriterion("UPDTM >", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDTM >=", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmLessThan(Date value) {
            addCriterion("UPDTM <", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmLessThanOrEqualTo(Date value) {
            addCriterion("UPDTM <=", value, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmIn(List<Date> values) {
            addCriterion("UPDTM in", values, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmNotIn(List<Date> values) {
            addCriterion("UPDTM not in", values, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmBetween(Date value1, Date value2) {
            addCriterion("UPDTM between", value1, value2, "updtm");
            return (Criteria) this;
        }

        public Criteria andUpdtmNotBetween(Date value1, Date value2) {
            addCriterion("UPDTM not between", value1, value2, "updtm");
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