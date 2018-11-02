package news.common.dto.criteria;

public class NewCriteria {
    private Integer newTypeId;
    private boolean isAllList;

    public boolean getIsAllList() {
        return isAllList;
    }

    public void setIsAllList(boolean isAllList) {
        isAllList = isAllList;
    }

    public Integer getNewTypeId() {
        return newTypeId;
    }

    public void setNewTypeId(Integer newTypeId) {
        this.newTypeId = newTypeId;
    }
}
