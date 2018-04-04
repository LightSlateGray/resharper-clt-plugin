package com.soloplan.oss.sonarqube.plugin.resharper.clt.interfaces;

import com.soloplan.oss.sonarqube.plugin.resharper.clt.models.SonarQubeRuleDefinitionModel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * An interface defining methods to convert from arbitrary instances to instances of the class {@link SonarQubeRuleDefinitionModel}.
 *
 * @param <T>
 *     The generic type parameter that defines the input of the implementation.
 */
public interface SonarQubeRuleDefinitionConverter<T> {

  /**
   * Converts a single instance of the generic type {@link T} to an instance of class {@link SonarQubeRuleDefinitionModel}. If argument
   * {@code instance} is {@code null}, {@code null} will be returned.
   *
   * @param instance
   *     An instance of the generic type {@link T}, which will be used to create a new {@link SonarQubeRuleDefinitionModel} instance. Might
   *     be {@code null}.
   *
   * @return A new {@link SonarQubeRuleDefinitionModel} instance, of which its properties are populated with values of the supplied {@code
   *     instance} of the generic type {@link T}. Might be {@code null} if the supplied {@code instance} is {@code null}.
   */
  @Contract("null -> null; !null -> !null")
  SonarQubeRuleDefinitionModel convert(@Nullable T instance);

  /**
   * Converts all instances contained within the supplied {@code collection} of generic type {@link T} to instances of class {@link
   * SonarQubeRuleDefinitionModel} and returns the {@link Collection} of converted instances.
   *
   * @param collection
   *     A {@link Collection} of the generic type {@link T}, of which each entry will be used to create a new instance of class {@link
   *     SonarQubeRuleDefinitionModel}. Might be {@code null} or an empty {@link Collection}.
   *
   * @return A new {@link Collection} of {@link SonarQubeRuleDefinitionModel} instances, of which each instance has been populated with
   *     values of the supplied {@code collection} of the generic type {@link T}. Should never be {@code null}, instead an empty {@link
   *     Collection} should be returned, even if the supplied {@code collection} is {@code null}.
   */
  @Contract("null -> !null; !null -> !null")
  Collection<SonarQubeRuleDefinitionModel> convert(@Nullable Collection<T> collection);
}
