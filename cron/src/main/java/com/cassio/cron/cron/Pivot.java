package com.cassio.cron.cron;

public class Pivot {

    private Integer id;

    public Pivot(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pivot pivot = (Pivot) o;

        return id != null ? id.equals(pivot.id) : pivot.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pivot{" +
                "id=" + id +
                '}';
    }
}
