[![Build Status](https://travis-ci.com/mtumilowicz/java-annotations-retention-policy.svg?branch=master)](https://travis-ci.com/mtumilowicz/java-annotations-retention-policy)

# java-annotations-retention-policy

# preview
|Enum Constant    |Description    |    Example
|-----------------|---|---|
|SOURCE           |Annotations are to be discarded by the compiler.    |@Override, @SuppressWarnings
|CLASS            |Annotations are to be recorded in the class file by the compiler but need not be retained by the VM at run time.    |lombok @NonNull
|RUNTIME          |Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.    |@Deprecated, @Target, @FunctionalInterface

# project description
We will provide examples with tests for each row of the table above.

1. `SourcePolicy`
    * java code
        ```
        @SuppressWarnings("unchecked")
        class SourcePolicy {
        }
        ```
    * compiled code
        ```
        class SourcePolicy {
            SourcePolicy() {
            }
        }
        ```
    * tests
        ```
        assertThat(SourcePolicy.class.getAnnotations(), arrayWithSize(0));
        ```
1. `ClassPolicy`
    * java code
        ```
        class ClassPolicy {
            @NonNull
            String nonNullField;
        }
        ```
    * compiled code
        ```
        class ClassPolicy {
            @NonNull
            String nonNullField;
        
            ClassPolicy() {
            }
        }
        ```
    * tests
        ```
        assertThat(ClassPolicy.class.getAnnotations(), arrayWithSize(0));
        ```
1. `RuntimePolicy`
    * java code
        ```
        @Deprecated
        class RuntimePolicy {
        }
        ```
    * compiled code
        ```
        @Deprecated
        class RuntimePolicy {
            RuntimePolicy() {
            }
        }
        ```
    * tests
        ```
        assertThat(RuntimePolicy.class.getAnnotations(), arrayWithSize(1));
        assertEquals(Deprecated.class, RuntimePolicy.class.getAnnotations()[0].annotationType());
        ```