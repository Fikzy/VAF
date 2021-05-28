package vaf.app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.time.LocalTime;

public class TimeRangeController extends HBox {

    private final ObjectProperty<LocalTime> fromTime = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalTime> toTime = new SimpleObjectProperty<>();

    public LocalTime getFromTime() {
        return fromTime.get();
    }

    public ObjectProperty<LocalTime> fromTimeProperty() {
        return fromTime;
    }

    public LocalTime getToTime() {
        return toTime.get();
    }

    public ObjectProperty<LocalTime> toTimeProperty() {
        return toTime;
    }

    public TimeRangeController(final String label, final LocalTime initialFrom, final LocalTime initialTo) {

        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(5);
        this.setPadding(new Insets(10));

        TimeSpinner fromTimeSpinner = new TimeSpinner(initialFrom);
        Text fromText = new Text("h à ");
        TimeSpinner toTimeSpinner = new TimeSpinner(initialTo);
        Text toText = new Text("h");
        Text title = new Text(label);

        this.getChildren().addAll(title, fromTimeSpinner, fromText, toTimeSpinner, toText);

        fromTime.bind(fromTimeSpinner.valueProperty());
        toTime.bind(toTimeSpinner.valueProperty());
    }
}
