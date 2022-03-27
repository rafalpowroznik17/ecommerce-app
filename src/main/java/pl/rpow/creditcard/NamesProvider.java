package pl.rpow.creditcard;

import com.fasterxml.jackson.databind.util.NameTransformer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesProvider {
    NameTransformer nameTransformer;

    public NamesProvider(NameTransformer namesTransformer) {
        this.nameTransformer = namesTransformer;
    }

    public List<String> allNames() {
        return Arrays
                .asList("Kuba", "Michal", "Krzys")
                .stream()
                .filter(names -> !name.equals("Rafal"))
                .map(names -> nameTransformer.transform(names))
                .collect(Collectors.toList())
                ;
    }
}
