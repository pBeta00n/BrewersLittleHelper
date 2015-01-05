
package se.angstroms.blh.anders.formulas.gravity;

import org.blh.core.formula.gravity.originalgravity.SimpleOriginalGravityFormula;
import org.blh.core.unit.gravity.SpecificGravity;

import se.angstroms.blh.anders.context.FullContext;
import se.angstroms.blh.anders.context.value.Value;
import se.angstroms.blh.anders.context.value.findingformulas.Formula;
import se.angstroms.blh.anders.formulas.ObservableFormula;

/**
 *
 * @author Thinner
 */
@Formula(calculates = Value.Id.OG)
public class ObservableSimpleOriginalGravityFormula extends ObservableFormula<SpecificGravity> {

	private final SimpleOriginalGravityFormula f;

	public ObservableSimpleOriginalGravityFormula(FullContext context) {
		super(context);

		f = new SimpleOriginalGravityFormula();
	}

	@Override
	protected void registerDependentVariables(FullContext context) {
		registerDependentVariable(context.getExtractionEfficiency());
		registerDependentVariable(context.getPostBoilVolume());
		registerDependentVariable(context.getIngredientsList().getFermentables(), Value.Id.FERMENTABLES);
	}

    @Override
    public SpecificGravity calc() {
		System.out.println("Calculating OG");
        return f.calc(getContext().getIngredientsList().getFermentables(),
                      getContext().getPostBoilVolume().get(),
                      getContext().getExtractionEfficiency().get());
    }
}
