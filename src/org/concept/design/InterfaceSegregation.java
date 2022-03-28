package org.concept.design;

public class InterfaceSegregation {
    /*
    * Larger interfaces should be split into smaller ones.
    * By doing so, we can ensure that implementing classes
    * only need to be concerned about the methods that are of required.
    *
    * */
}
interface Pipeline{}

interface Stages{}

interface Reports{}

interface Deployments{}

