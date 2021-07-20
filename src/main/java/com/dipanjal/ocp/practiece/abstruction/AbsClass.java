package com.dipanjal.ocp.practiece.abstruction;

import java.util.Objects;

/**
 * @author dipanjal
 * @since 4/18/2021
 */

public abstract class AbsClass {
    private Object obj;
    private String name;
    public String getName(){
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsClass absClass = (AbsClass) o;
        return name.equals(absClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
