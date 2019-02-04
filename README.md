# annotations-retention-policy

|Enum Constant    |Description    |    Example
|-----------------|---|---|
|SOURCE           |Annotations are to be discarded by the compiler.    |@Override, @SuppressWarnings
|CLASS            |Annotations are to be recorded in the class file by the compiler but need not be retained by the VM at run time.    |lombok @NonNull
|RUNTIME          |Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.    |@Deprecated, @Target, @FunctionalInterface

1. `SourcePolicy`
    * code
        ```
        @SuppressWarnings("unchecked")
        class SourcePolicy {
        }
        ```
    * tests
        ```
        assertThat(SourcePolicy.class.getAnnotations(), arrayWithSize(0));
        ```
1. `ClassPolicy`
    * code
        ```
        class ClassPolicy {
            @NonNull
            String nonNullField;
        }
        ```
    * tests
        ```
        assertThat(ClassPolicy.class.getAnnotations(), arrayWithSize(0));
        ```
1. `RuntimePolicy`
    * code
        ```
        @Deprecated
        class RuntimePolicy {
        }
        ```
    * tests
        ```
        assertThat(RuntimePolicy.class.getAnnotations(), arrayWithSize(1));
        assertThat(RuntimePolicy.class.getAnnotations()[0].annotationType(), is(instanceOf(Deprecated.class)));
        ```