package Presenters;

import Models.TableService;
import View.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver{

    private Model model;
    private View view;
    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservation){
        view.showReservationTableResult(reservation);
    }


    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo =  model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }

    @Override
    public void onChangereservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo =  model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }
    }


}
