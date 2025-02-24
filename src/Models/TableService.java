package Models;

import Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;
    @Override
    public Collection<Table> loadTables() {
        if(tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: tables){
            if(table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int a = 1;
        for (Table table : tables) {
            for (Reservation r : table.getReservations()) {
                if (r.getId() == oldReservation) {
                    table.getReservations().remove(r);
                    a++;
                    break;
                }
            }
        }
        if (a == 1) {
            System.out.println("Бронь не найдена. Будет создана новая бронь");
        } else {
            System.out.printf("Бронь №%d была успешно отменена\n", oldReservation);
        }

        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }
}

