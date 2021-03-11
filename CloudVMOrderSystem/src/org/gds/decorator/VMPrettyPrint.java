/**
 * 
 */
package org.gds.decorator;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.gds.component.VirtualMachine;

/**
 * In Chapter 3 of the book Head First Design Patterns on page 99, in the No
 * Dumb Questions section, one of the answers suggests a "PrettyPrint" decorator
 * as pushing the limit of this pattern. I was interested in exploring this
 * suggestion.
 * 
 * Overall, I would say the implementation works reasonably well. To work
 * properly, this decorator must always be the last decorator used when
 * decorating the original, concrete component. Further, the VirtualMachine
 * attribute which this Object was composed with, must have its label string
 * specifically formatted for the logic to work.
 */
public class VMPrettyPrint extends VMDecorator {

    VirtualMachine vm;

    public VMPrettyPrint(VirtualMachine vm) {
        this.vm = vm;
    }

    public String getLabel() {
        // split the string on the comma character
        String[] stringArr = vm.getLabel().split(",");
        String prettyPrintLabel = stringArr[0];

        // remove the first element of the array, it's the main VM label
        String[] decorationsArr = Arrays.copyOfRange(stringArr, 1, stringArr.length);

        // use a sorted map implementation to maintain an insertion ordering of the keys
        Map<String, Integer> decorationMap = new LinkedHashMap<>();
        for (String decoration : decorationsArr) {
            // strip any whitespace of the full decoration string
            decoration = decoration.replaceAll("\\s", "");
            String[] decArr = decoration.split(":");

            String decorationLabel = decArr[0];
            Integer decorationValue = Integer.valueOf(decArr[1]);
            // if a value for this label is already in the map, retrieve it to compute new
            // total.
            if (decorationMap.containsKey(decorationLabel)) {
                Integer existingValue = decorationMap.get(decorationLabel);
                decorationMap.put(decorationLabel, existingValue + decorationValue);
            } else {
                decorationMap.put(decorationLabel, decorationValue);
            }
        }

        // iterate the sorted map to generate the output string
        for (Map.Entry<String, Integer> decEntry : decorationMap.entrySet()) {
            String key = decEntry.getKey();
            Integer value = decEntry.getValue();

            prettyPrintLabel += ", " + key + ": " + value;
        }
        return prettyPrintLabel;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gds.VirtualMachine#costPerMonth()
     */
    @Override
    public double costPerMonth() {
        return vm.costPerMonth();
    }

}
