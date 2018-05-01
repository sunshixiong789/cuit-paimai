package cn.edu.cuit.common;

/**
 * @author sunshixiong
 * @date 2018/2/5 10:46
 */
public enum  CommonCRUD {
    JPAREPOSITORY_SAVE(1,"添加数据异常"),
    JPAREPOSITORY_UPDATE(2,"更新数据异常"),
    JPAREPOSITORY_DELETE(3,"删除数据失败"),
    JPAREPOSITORY_QUERY(4,"查询数据列表失败"),
    JPAREPOSITORY_QUERYPAGE(5,"查询列表并且分页失败");

    private final int value;

    private final String message;

    CommonCRUD(int value, String message) {
        this.value = value;
        this.message = message;
    }
    public int value() {
        return this.value;
    }
    public String message() {
        return this.message;
    }
}
