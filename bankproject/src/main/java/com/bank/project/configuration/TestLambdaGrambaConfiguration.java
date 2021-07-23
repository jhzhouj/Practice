package com.bank.project.configuration;

import be.cloudway.easy.reflection.dependency.configuration.ScanForReflectionInterface;
import be.cloudway.easy.reflection.dependency.configuration.reflection.PackageScanConfiguration;
import be.cloudway.gramba.annotations.GrambaConfigurationTarget;

import java.util.List;

@GrambaConfigurationTarget
public class TestLambdaGrambaConfiguration implements ScanForReflectionInterface {
    @Override
    public List<PackageScanConfiguration> scanPackages(List<PackageScanConfiguration> reflectedPackages) {
        reflectedPackages.add(new PackageScanConfiguration("com.bank.project.model"));
        return reflectedPackages;
    }
}
