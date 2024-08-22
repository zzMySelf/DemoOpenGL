package com.baidu.searchbox.sport.page.tournament.model;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Tournament implements Serializable {
    String description;
    String logo;
    String name;

    public String getName() {
        return this.name;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Tournament{name='" + this.name + '\'' + ", logo='" + this.logo + '\'' + ", description='" + this.description + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
