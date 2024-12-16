; ModuleID = 'MiniPascal'
source_filename = "test"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-microsoft-msvc"
%struct._IO_FILE = type { i8*, i32, i32, i32, i8*, i8*, i8*, i8*, i8*, i32, i32, i32, i32, i8*, i8*, i8*, i32, i32, i32 }
@buffer = global [256 x i8] zeroinitializer
@str_fmt = unnamed_addr constant [4 x i8] c"%d\0A\00"
@stdin = external global %struct._IO_FILE*
@double_fmt = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@char_fmt = private unnamed_addr constant [4 x i8] c"%c\0A\00"
@.str5 = private constant [9 x i8] c"numero: \00"
@.str4 = private constant [11 x i8] c"caracter: \00"
@.str3 = private constant [9 x i8] c"numero: \00"
@.str2 = private constant [9 x i8] c"no entro\00"
@.str1 = private constant [6 x i8] c"entro\00"
define i32 @f(i32 %cont_num, i32 %cont_NUM2, i8 %cont_caracter, i8* %cont_cadena, i1 %cont_flag) {
entry:
    %f = alloca i32
    %num = alloca i32
    store i32 %cont_num, i32* %num
    %num_val1 = load i32, i32* %num
    %NUM2 = alloca i32
    store i32 %cont_NUM2, i32* %NUM2
    %NUM2_val2 = load i32, i32* %NUM2
    %caracter = alloca i8
    store i8 %cont_caracter, i8* %caracter
    %caracter_val3 = load i8, i8* %caracter
    %flag = alloca i1
    store i1 %cont_flag, i1* %flag
    %flag_val4 = load i1, i1* %flag

    %numero = alloca i32
    call void @write_string(i8* getelementptr inbounds ([9 x i8], [9 x i8]* @.str3, i32 0, i32 0))
    call void @write_int(i32 %num_val1)
    call void @write_string(i8* getelementptr inbounds ([11 x i8], [11 x i8]* @.str4, i32 0, i32 0))
    call void @write_char(i8 %caracter_val3)
    store i32 40, i32* %numero
    %numero_val5 = load i32, i32* %numero

    store i32 11, i32* %f
    %f_val6 = load i32, i32* %f

    ret i32 %f_val6
}

@cadena9 = private constant [5 x i8] c"hola\00"

define i32 @main() {
    %x = alloca i8
    %numero = alloca i32
    br i1 %flag_val4, label %then1, label %else1
then1:
    call void @write_string(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.str1, i32 0, i32 0))
    br label %merge1
else1:
    call void @write_string(i8* getelementptr inbounds ([9 x i8], [9 x i8]* @.str2, i32 0, i32 0))
    br label %merge1
merge1:
    store i8 83, i8* %x
    %x_val7 = load i8, i8* %x
%ptr_cadena9 = bitcast [5 x i8]* @cadena9 to i8*
    %numero_val8 = call i32 @f(i32 3, i32 2, i8 %x_val7, i8* %ptr_cadena9, i1 1)
    call void @write_string(i8* getelementptr inbounds ([9 x i8], [9 x i8]* @.str5, i32 0, i32 0))
    call void @write_int(i32 %numero_val8)
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

