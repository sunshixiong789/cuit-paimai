package cn.edu.cuit.cuitpaimairesource.common;

/**
 * json视图查看等级
 * @author sunshixiong
 * @date 2018/2/2 14:44
 */
public interface CommonJsonView {
    interface SimpleView {}
    interface DetailView extends SimpleView {}
    interface AllView extends DetailView{}
}
