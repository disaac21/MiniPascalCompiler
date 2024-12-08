declare i32 @scanf(i8*, ...)

@int_format = private constant [3 x i8] c"%d\00"; Formato para enteros
@char_format = private constant [3 x i8] c"%c\00"      ; Formato para caracteres
@str_format = private constant [3 x i8] c"%s\00"       ; Formato para cadenas

@buffer = private global [256 x i8] zeroinitializer    ; Buffer para almacenar cadenas

define i32 @main() {
entry:
    ; Reservar espacio para las variables
    %int_var = alloca i32
    %char_var = alloca i8
    %str_var = alloca i8*

    ; Leer un entero
    %int_ptr = bitcast i32* %int_var to i8*            ; Convertir puntero entero para scanf
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @int_format to i8*), i8* %int_ptr)

    ; Leer un carácter
    %char_ptr = bitcast i8* %char_var to i8*           ; Convertir puntero char para scanf
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @char_format to i8*), i8* %char_ptr)

    ; Leer una cadena
    %str_ptr = getelementptr [256 x i8], [256 x i8]* @buffer, i32 0, i32 0
    call i32 (i8*, ...) @scanf(i8* bitcast ([3 x i8]* @str_format to i8*), i8* %str_ptr)
    store i8* %str_ptr, i8** %str_var                  ; Guardar puntero al buffer en str_var

    ; Retornar 0
    ret i32 0
}
