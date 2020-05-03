import java.util.ArrayList;
import java.util.List;

public class RealEstateAgentProxy {
    private List<Apartment> apartments = new ArrayList<>();

    public void represent(Apartment appartment) {

        apartments.add(appartment);

    }

    public Apartment rent(Student student) {

        if (!student.getName().startsWith("P")) {

            Apartment finalApartament = new Apartment("", Integer.MAX_VALUE);
            for (Apartment apartment : apartments) {
                if (student.getMoney() >= apartment.getMonthlyRentCost()) {
                    if(finalApartament.getMonthlyRentCost() > apartment.getMonthlyRentCost()) {
                        finalApartament = apartment;
                    }
                }
            }
            if(finalApartament.getMonthlyRentCost() != Integer.MAX_VALUE) {
                apartments.remove(finalApartament);
                return finalApartament;
            }
        }
        return null;

    }

}


