// Wirakorn Thanabat
// 6809617415

package escapeFromLandmines;

import escapeFromLandmines.Resource.Dimension;

public interface Selectable {
    Dimension choose(Dimension range);
}