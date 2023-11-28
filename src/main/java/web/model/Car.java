package web.model;

import java.util.Objects;

public class Car {
    private String model;
    private Integer Year_of_release;
    private String Number;

    public Car() {
    }

    public Car(String model, Integer year_of_release, String number) {
        this.model = model;
        this.Year_of_release = year_of_release;
        this.Number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear_of_release() {
        return Year_of_release;
    }

    public void setYear_of_release(Integer year_of_release) {
        Year_of_release = year_of_release;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(getModel(), car.getModel()) && Objects.equals(getYear_of_release(), car.getYear_of_release()) && Objects.equals(getNumber(), car.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getYear_of_release(), getNumber());
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", Year_of_release=" + Year_of_release +
                ", Number='" + Number + '\'' +
                '}';
    }
}
