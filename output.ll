; ModuleID = 'MiniPascal'
source_filename = "IncrementI"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-microsoft-msvc"
%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }
@buffer = global [256 x i8] zeroinitializer
@str_fmt = unnamed_addr constant [4 x i8] c"%d\0A\00"
@stdin = external global %struct._IO_FILE*
@double_fmt = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@char_fmt = private unnamed_addr constant [4 x i8] c"%c\0A\00"
@.str3 = private constant [54 x i8] c"i is greater than or equal to 3. Current value of i: \00"
@.str2 = private constant [21 x i8] c"Current value of i: \00"
@.str1 = private constant [4 x i8] c"i: \00"
define void @CheckAndIncrement(i32 %cont_i) {
entry:
    %i = alloca i32
    store i32 %cont_i, i32* %i
    %i_val1 = load i32, i32* %i

    call void @write_string(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i32 0, i32 0))
    call void @write_int(i32 %i_val1)
br label %while_condition1
while_condition1:
    %cond1 = icmp slt i32 %i_val1, 5
    br i1 %cond1, label %while_body1, label %while_end1
while_body1:
    %cond2 = icmp slt i32 %i_val1, 3
    br i1 %cond2, label %then1, label %else1
then1:
    call void @write_string(i8* getelementptr inbounds ([21 x i8], [21 x i8]* @.str2, i32 0, i32 0))
    call void @write_int(i32 %i_val1)
    br label %merge1
else1:
    call void @write_string(i8* getelementptr inbounds ([54 x i8], [54 x i8]* @.str3, i32 0, i32 0))
    call void @write_int(i32 %i_val1)
    br label %merge1
merge1:
%t2 = add i32 %i_val1, 1
store i32 %t2, i32* %i
%i_val3 = load i32, i32* %i
    br label %while_condition1
while_end1:
    ret void
}


define i32 @main() {
    %i = alloca i32
    store i32 0, i32* %i
    %i_val4 = load i32, i32* %i
    call void @CheckAndIncrement(i32 %i_val4)
  ret i32 0
}

define void @write_int(i32 %num) {
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str_fmt, i32 0, i32 0), i32 %num)
    ret void
}

define void @write_char(i8 %char) {
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @char_fmt, i32 0, i32 0), i8 %char)
    ret void
}
define void @write_string(i8* %str) {
    call i32 @puts(i8* %str)
    ret void
}

declare i32 @atoi(i8*)
declare i32 @sprintf(i8*, i8*, ...)
declare i32 @puts(i8*)
declare i8* @fgets(i8*, i32, %struct._IO_FILE*)
declare void @exit(i32)

; Function Attrs: noinline nounwind optnone uwtable
declare i32 @printf(i8*, ...) #0
attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
!llvm.module.flags = !{!0}

!llvm.ident = !{!1}
!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 10.0.0-4ubuntu1 "}

