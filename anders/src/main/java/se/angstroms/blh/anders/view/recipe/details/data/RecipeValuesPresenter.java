package se.angstroms.blh.anders.view.recipe.details.data;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javax.inject.Inject;
import se.angstroms.blh.anders.uncategorized.context.FullContext;
import se.angstroms.blh.anders.uncategorized.value.InputtedOrCalculatedValue;
import se.angstroms.blh.anders.uncategorized.value.Value;
import se.angstroms.blh.anders.uncategorized.value.ValueId;
import se.angstroms.blh.anders.uncategorized.value.parsing.UnitStringParserFactory;
import se.angstroms.blh.anders.view.recipe.details.data.value.ValuePresenter;
import se.angstroms.blh.anders.view.util.CustomControl;

/**
 *
 * @author Thinner
 */
public class RecipeValuesPresenter extends VBox {

    private static enum GridElement {

        bitterness("Bitterness", ValueId.BITTERNESS, 0, 0),
        og("Original gravity", ValueId.OG, 1, 0),
        fg("Final Gravity", ValueId.FG, 2, 0),
        abv("Alcohol content", ValueId.ALCOHOL_CONTENT, 3, 0),
        extractionEfficency("Extraction efficiency", ValueId.EXTRACTION_EFFICIENCY, 0, 1);

        private final String title;
        private final ValueId type;
        private final int row;
        private final int column;

        private GridElement(String title, ValueId type, int row, int column) {
            this.title = title;
            this.type = type;
            this.row = row;
            this.column = column;
        }

        public String getTitle() {
            return title;
        }

        public ValueId getType() {
            return type;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    @Inject
    private UnitStringParserFactory unitStringParserFactory;

    @FXML
    private GridPane grid;

    private final ObjectProperty<FullContext> recipeProperty;

    public RecipeValuesPresenter() {
        CustomControl.setup(this);
        recipeProperty = new SimpleObjectProperty<>();
        recipeProperty.addListener(new ChangeListener<FullContext>() {

            @Override
            public void changed(ObservableValue<? extends FullContext> ov, FullContext t, FullContext newRecipe) {
                populateGrid();
            }
        });
    }

    public ObjectProperty<FullContext> recipeProperty() {
        return recipeProperty;
    }

    private void populateGrid() {
        grid.getChildren().clear();
        int cellsPerElement = 3;

        for (GridElement element : GridElement.values()) {
            int column = element.getColumn() * cellsPerElement;
            ValuePresenter valuePresenter = typeToValuePresenter(element.getType());

            grid.add(new Label(element.title), column, element.getRow());
            grid.add(valuePresenter, column + 1, element.getRow());
            grid.add(valuePresenter.getGoBackToCalculatedButton(), column + 2, element.getRow());
        }
    }

    private ValuePresenter typeToValuePresenter(ValueId type) {
        Value<?> value = recipeProperty.get().get(type);
        InputtedOrCalculatedValue<?> valueAsIOCV = (InputtedOrCalculatedValue<?>) value;
        return new ValuePresenter(valueAsIOCV, unitStringParserFactory.getParserFor(type));
    }
}
