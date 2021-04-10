package com.yy.study.test;

/**
 * @desc 自定义数组
 * @author wyy
 * @since 2021-04-08 21:13
 */
public class DynamicArrayList {

    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 3;
    private static final int ELEMENT_NOT_FOUND = -1;

    public DynamicArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        elements = new int[capaticy];
    }

    public DynamicArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        size = 0;
    }

    /**
     * 元素的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(int element) {
        //add(size,element);
        //
        isExpansion(size+1);
        elements[size] = element;
        size++;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组长度size："+size+", index: "+index);
        }
      return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public int set(int index, int element) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组长度size："+size+", index: "+index);
        }
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index, int element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组长度size："+size+", index: "+index);
        }
        // 扩容
        isExpansion(size+1);
        size++;
        for (int i = size; i > index; i--) {
                elements[i] = elements[i-1];
        }
        elements[index] = element;
    }

    /**
     * 判断是否进行扩容
     *
     * @param criticalSize 至少需要的元素个数 size+1
     */
    private void isExpansion(int criticalSize){
        // 当前容量大于至少需要容量时，不需要扩容
        int oldCapacity = elements.length;
        if (oldCapacity >= criticalSize)return;

        int newCapacity  = oldCapacity + (oldCapacity >> 1);
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        System.out.println(oldCapacity+" 扩容为："+newCapacity);
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组长度size："+size+", index: "+index);
        }
        int old = elements[index];
        for (int i = index +1; i <= size-1; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element){
                return i;
            }
        }
        return -1;
    }

//	public int indexOf2(E element) {
//		for (int i = 0; i < size; i++) {
//			if (valEquals(element, elements[i])) return i; // 2n
//		}
//		return ELEMENT_NOT_FOUND;
//	}
//
//	private boolean valEquals(Object v1, Object v2) {
//		return v1 == null ? v2 == null : v1.equals(v2);
//	}

    /**
     * 保证要有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {

    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index) {

    }

    private void rangeCheckForAdd(int index) {

    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);

//			if (i != size - 1) {
//				string.append(", ");
//			}
        }
        string.append("]");
        return string.toString();
    }
}
