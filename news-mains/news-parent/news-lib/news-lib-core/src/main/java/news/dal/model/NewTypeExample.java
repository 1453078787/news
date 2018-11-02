package news.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewTypeExample() {
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

        public Criteria andNewTypeIdIsNull() {
            addCriterion("new_type_id is null");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdIsNotNull() {
            addCriterion("new_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdEqualTo(Integer value) {
            addCriterion("new_type_id =", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdNotEqualTo(Integer value) {
            addCriterion("new_type_id <>", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdGreaterThan(Integer value) {
            addCriterion("new_type_id >", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_type_id >=", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdLessThan(Integer value) {
            addCriterion("new_type_id <", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("new_type_id <=", value, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdIn(List<Integer> values) {
            addCriterion("new_type_id in", values, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdNotIn(List<Integer> values) {
            addCriterion("new_type_id not in", values, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("new_type_id between", value1, value2, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("new_type_id not between", value1, value2, "newTypeId");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameIsNull() {
            addCriterion("new_type_name is null");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameIsNotNull() {
            addCriterion("new_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameEqualTo(String value) {
            addCriterion("new_type_name =", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameNotEqualTo(String value) {
            addCriterion("new_type_name <>", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameGreaterThan(String value) {
            addCriterion("new_type_name >", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("new_type_name >=", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameLessThan(String value) {
            addCriterion("new_type_name <", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameLessThanOrEqualTo(String value) {
            addCriterion("new_type_name <=", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameLike(String value) {
            addCriterion("new_type_name like", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameNotLike(String value) {
            addCriterion("new_type_name not like", value, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameIn(List<String> values) {
            addCriterion("new_type_name in", values, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameNotIn(List<String> values) {
            addCriterion("new_type_name not in", values, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameBetween(String value1, String value2) {
            addCriterion("new_type_name between", value1, value2, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andNewTypeNameNotBetween(String value1, String value2) {
            addCriterion("new_type_name not between", value1, value2, "newTypeName");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("DELETED is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("DELETED =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("DELETED <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("DELETED >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("DELETED >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("DELETED <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("DELETED <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("DELETED in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("DELETED not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("DELETED between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("DELETED not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(Integer value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(Integer value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(Integer value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(Integer value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(Integer value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<Integer> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<Integer> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameIsNull() {
            addCriterion("CREATED_BY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameIsNotNull() {
            addCriterion("CREATED_BY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameEqualTo(String value) {
            addCriterion("CREATED_BY_NAME =", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameNotEqualTo(String value) {
            addCriterion("CREATED_BY_NAME <>", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameGreaterThan(String value) {
            addCriterion("CREATED_BY_NAME >", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY_NAME >=", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameLessThan(String value) {
            addCriterion("CREATED_BY_NAME <", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY_NAME <=", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameLike(String value) {
            addCriterion("CREATED_BY_NAME like", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameNotLike(String value) {
            addCriterion("CREATED_BY_NAME not like", value, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameIn(List<String> values) {
            addCriterion("CREATED_BY_NAME in", values, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameNotIn(List<String> values) {
            addCriterion("CREATED_BY_NAME not in", values, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameBetween(String value1, String value2) {
            addCriterion("CREATED_BY_NAME between", value1, value2, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedByNameNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY_NAME not between", value1, value2, "createdByName");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("CREATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("CREATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("CREATED_TIME =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("CREATED_TIME <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("CREATED_TIME >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("CREATED_TIME <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_TIME <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("CREATED_TIME in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("CREATED_TIME not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(Integer value) {
            addCriterion("UPDATED_BY =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(Integer value) {
            addCriterion("UPDATED_BY <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(Integer value) {
            addCriterion("UPDATED_BY >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPDATED_BY >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(Integer value) {
            addCriterion("UPDATED_BY <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(Integer value) {
            addCriterion("UPDATED_BY <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<Integer> values) {
            addCriterion("UPDATED_BY in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<Integer> values) {
            addCriterion("UPDATED_BY not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(Integer value1, Integer value2) {
            addCriterion("UPDATED_BY between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(Integer value1, Integer value2) {
            addCriterion("UPDATED_BY not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameIsNull() {
            addCriterion("UPDATED_BY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameIsNotNull() {
            addCriterion("UPDATED_BY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameEqualTo(String value) {
            addCriterion("UPDATED_BY_NAME =", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameNotEqualTo(String value) {
            addCriterion("UPDATED_BY_NAME <>", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameGreaterThan(String value) {
            addCriterion("UPDATED_BY_NAME >", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY_NAME >=", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameLessThan(String value) {
            addCriterion("UPDATED_BY_NAME <", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY_NAME <=", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameLike(String value) {
            addCriterion("UPDATED_BY_NAME like", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameNotLike(String value) {
            addCriterion("UPDATED_BY_NAME not like", value, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameIn(List<String> values) {
            addCriterion("UPDATED_BY_NAME in", values, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameNotIn(List<String> values) {
            addCriterion("UPDATED_BY_NAME not in", values, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameBetween(String value1, String value2) {
            addCriterion("UPDATED_BY_NAME between", value1, value2, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNameNotBetween(String value1, String value2) {
            addCriterion("UPDATED_BY_NAME not between", value1, value2, "updatedByName");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("UPDATED_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("UPDATED_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("UPDATED_TIME =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("UPDATED_TIME <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("UPDATED_TIME >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("UPDATED_TIME <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_TIME <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("UPDATED_TIME in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("UPDATED_TIME not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_TIME not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
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