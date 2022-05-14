package com.dipanjal.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignationManager {

    public static class Designation {
        int id;
        int parentId;
        String name;

        public Designation(int id, int parentId, String name) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    private Map<Integer, List<Designation>> designationMap = new HashMap<>(){{
        put(0, List.of(new Designation(1, 0, "CTO")));
        put(1, List.of(
                new Designation(2, 1, "Senior Software Engineer"),
                new Designation(4, 1, "Product Manager"),
                new Designation(5, 2, "Project Manager")
        ));
        put(2, List.of(new Designation(3, 2, "Software Engineer")));
    }};

    public List<String> getDesignations(int parentId) {
        List<String> result = new ArrayList<>();
        getChildren(parentId, result);
        return result;
    }

    public void getChildren(int parentId, List<String> result) {
        List<Designation> children = designationMap.get(parentId);
        if(children != null && !children.isEmpty()) {
            for(Designation child : children) {
                result.add(child.name);
                getChildren(child.id, result);
            }
        }

    }

    public static void main(String[] args) {
        DesignationManager manager = new DesignationManager();
        List<String> designationList = manager.getDesignations(1);
        System.out.println(designationList);
    }

}
