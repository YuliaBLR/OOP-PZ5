import Models.Table;
import Models.TableService;
import Presenters.BookingPresenter;
import Presenters.Model;
import View.BookingView;

import java.util.Date;

/**
 * Домашнее задание:
 * Метод changeReservationTable должен заработать
 *
 */
public class Programm {
    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTablesView();
        view.reservationTable(new Date(), 2, "Станислав");

        view.changeReservationTable(1001, new Date(), 4, "Станислав");

    }

}
