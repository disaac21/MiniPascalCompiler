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
@.str11 = private constant [13 x i8] c"valor de i: \00"
@.str10 = private constant [4 x i8] c"x: \00"
@.str9 = private constant [5 x i8] c"x3: \00"
@.str8 = private constant [10 x i8] c"menor a 5\00"
@.str7 = private constant [10 x i8] c"mayor a 5\00"
@.str6 = private constant [5 x i8] c"x2: \00"
@.str5 = private constant [5 x i8] c"hola\00"
@.str4 = private constant [15 x i8] c"no entro al if\00"
@.str3 = private constant [12 x i8] c"entro al if\00"

@str_format = private constant [3 x i8] c"%s\00"       ; Formato para cadenas
@.str2 = private constant [12 x i8] c"car leido: \00"

@char_format = private constant [4 x i8] c" %c\00"      ; Formato para caracteres
@.str1 = private constant [12 x i8] c"num leido: \00"

@int_format = private constant [3 x i8] c"%d\00"       ; Formato para enteros

declare i32 @scanf(i8*, ...)

define i32 @main() {
    %x = alloca i32
    %x2 = alloca i32
    %x3 = alloca i32
    %i = alloca i32
    %num = alloca i32
    %car = alloca i8
    %cadena = alloca i8*
    %int_ptr72 = bitcast i32* %num to i8* ;
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr72)
    %num_val72 = load i32, i32* %num
    call void @write_string(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @.str1, i32 0, i32 0))
    call void @write_int(i32 %num_val72)
    %char_ptr73 = bitcast i8* %car to i8* ;
    call i32 (i8*, ...) @scanf(i8* bitcast ([4 x i8]* @char_format to i8*), i8* %char_ptr73)
    %car_val73 = load i8, i8* %car
    call void @write_string(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @.str2, i32 0, i32 0))
    call void @write_char(i8 %car_val73)
    %str_ptr74 = getelementptr inbounds [256 x i8], [256 x i8]* @buffer, i32 0, i32 0
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr74)
    store i8* %str_ptr74, i8** %cadena
    %cadena_val74 = load i8*, i8** %cadena
    %cond1 = icmp sle i32 %num_val72, 3
    br i1 %cond1, label %then1, label %else1
then1:
    call void @write_string(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @.str3, i32 0, i32 0))
    br label %merge1
else1:
    call void @write_string(i8* getelementptr inbounds ([15 x i8], [15 x i8]* @.str4, i32 0, i32 0))
    br label %merge1
merge1:
    %j = alloca i32
    store i32 1, i32* %j
    br label %for_condition75

for_condition75:
    %j_val75 = load i32, i32* %j
    %cond2 = icmp slt i32 %j_val75, 10
    br i1 %cond2, label %for_body75, label %for_end75

for_body75:
    call void @write_string(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str5, i32 0, i32 0))
   %next_j_val75 = add i32 %j_val75, 1
   store i32 %next_j_val75, i32* %j
   br label %for_condition75

for_end75:
%t76 = add i32 3, 8
%t77 = sub i32 %t76, 4
store i32 %t77, i32* %x2
    %x2_val78 = load i32, i32* %x2
    call void @write_string(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str6, i32 0, i32 0))
    call void @write_int(i32 %x2_val78)
    %cond4 = icmp sgt i32 %x2_val78, 5
    br i1 %cond4, label %then2, label %else2
then2:
    call void @write_string(i8* getelementptr inbounds ([10 x i8], [10 x i8]* @.str7, i32 0, i32 0))
    br label %merge2
else2:
    call void @write_string(i8* getelementptr inbounds ([10 x i8], [10 x i8]* @.str8, i32 0, i32 0))
    br label %merge2
merge2:
%t79 = mul i32 80, 43
%t80 = add i32 42, %t79
%t81 = sdiv i32 798, 2
%t82 = add i32 %t80, %t81
%t83 = sub i32 %t82, 3
store i32 %t83, i32* %x3
    %x3_val84 = load i32, i32* %x3
    call void @write_string(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str9, i32 0, i32 0))
    call void @write_int(i32 %x3_val84)
%t85 = mul i32 2, %x2_val78
%t86 = add i32 1, %t85
store i32 %t86, i32* %x
    %x_val87 = load i32, i32* %x
    store i32 0, i32* %i
    
    call void @write_string(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str10, i32 0, i32 0))
    call void @write_int(i32 %x_val87)
br label %while_condition1
while_condition1:
    %i_val88 = load i32, i32* %i

    %cond7 = icmp slt i32 %i_val88, %x_val87
    br i1 %cond7, label %while_body1, label %while_end1
while_body1:
    call void @write_string(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @.str11, i32 0, i32 0))
    call void @write_int(i32 %i_val88)
%t89 = add i32 %i_val88, 1
store i32 %t89, i32* %i
    %i_val90 = load i32, i32* %i
    br label %while_condition1
while_end1:
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

