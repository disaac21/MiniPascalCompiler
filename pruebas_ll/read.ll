declare i32 @scanf(i8*, ...)  ; Declarar scanf
declare i32 @printf(i8*, ...) ; Declarar printf

@int_format = private constant [3 x i8] c"%d\00"  ; Formato para enteros
@char_format = private constant [3 x i8] c"%c\00" ; Formato para caracteres
@str_format = private constant [3 x i8] c"%s\00"  ; Formato para cadenas

@int_out_format = private constant [13 x i8] c"Integer: %d\0A\00" ; "Integer: %d\n"
@char_out_format = private constant [10 x i8] c"Char: %c\0A\00"    ; "Char: %c\n"
@str_out_format = private constant [12 x i8] c"String: %s\0A\00"   ; "String: %s\n"

@buffer = private global [256 x i8] zeroinitializer ; Buffer para cadenas

define i32 @main() {
entry:
    ; Reservar espacio para las variables
    %int_var = alloca i32
    %char_var = alloca i8
    %str_var = alloca i8*

    ; Leer un entero
    %int_ptr = bitcast i32* %int_var to i8*
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr)

    ; Imprimir el entero
    %int_val = load i32, i32* %int_var
    call i32 (i8*, ...) @printf(i8* bitcast ([13 x i8]* @int_out_format to i8*), i32 %int_val)

    ; Leer un carácter
    %char_ptr = bitcast i8* %char_var to i8*
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @char_format to i8*), i8* %char_ptr)

    ; Imprimir el carácter
    %char_val = load i8, i8* %char_var
    call i32 (i8*, ...) @printf(i8* bitcast ([10 x i8]* @char_out_format to i8*), i8 %char_val)

    ; Leer una cadena
    %str_ptr = getelementptr [256 x i8], [256 x i8]* @buffer, i32 0, i32 0
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr)
    store i8* %str_ptr, i8** %str_var

    ; Imprimir la cadena
    %loaded_str = load i8*, i8** %str_var
    call i32 (i8*, ...) @printf(i8* bitcast ([12 x i8]* @str_out_format to i8*), i8* %loaded_str)

    ; Retornar 0
    ret i32 0
}
