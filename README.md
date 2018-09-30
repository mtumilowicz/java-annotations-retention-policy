# annotations-retention-policy
|Enum Constant    |Description    |    Example
|-----------------|---|---|
|SOURCE           |Annotations are to be discarded by the compiler.    |@Override, @SuppressWarnings
|CLASS            |Annotations are to be recorded in the class file by the compiler but need not be retained by the VM at run time.    |lombok @NonNull
|RUNTIME          |Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.    |@Deprecated, @Target, @FunctionalInterface