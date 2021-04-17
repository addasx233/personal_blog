package com.yamlapkei.view;

public class TypeInfo {
    private String id;
    private String name;
    private String sort;

    public TypeInfo(String id, String name, String sort) {
        this.id = id;
        this.name = name;
        this.sort = sort;
    }

    public TypeInfo() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
