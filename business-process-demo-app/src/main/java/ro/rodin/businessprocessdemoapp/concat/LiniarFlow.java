package ro.rodin.businessprocessdemoapp.concat;

import ro.rodin.businessprocessdemoapp.FormatName;
import ro.rodin.businessprocessdemoapp.SimplifyName;

public class LiniarFlow {

    private SimplifyName simplifyName;
    private FormatName formatName;

    public LiniarFlow(SimplifyName simplifyName, FormatName formatName) {
        this.simplifyName = simplifyName;
        this.formatName = formatName;
    }

    public String process(String firstName, String lastName) {
        String simpleName = simplifyName.apply(firstName, lastName);
        String result = formatName.apply(simpleName);
        return result;
    }
}
