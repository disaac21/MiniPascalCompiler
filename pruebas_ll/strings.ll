@hola = private constant [5 x i8] c"hola\00"      ; Cadena inicial "hola"
@holahola = private constant [9 x i8] c"holahola\00" ; Nueva cadena "holahola"

define i32 @main() {
entry:
    ; Reservar espacio para la cadena (puntero a i8)
    %palabra = alloca i8*                        ; Reservar espacio para el puntero a la cadena
    %temp_ptr = alloca i8*                        ; Reservar un puntero temporal para cambiar el valor

    ; Asignar "hola" a palabra
    %hola_ptr = getelementptr [5 x i8], [5 x i8]* @hola, i32 0, i32 0
    store i8* %hola_ptr, i8** %palabra            ; Guardar la dirección de "hola" en %palabra

    ; Cambiar el valor de palabra a "holahola"
    %holahola_ptr = getelementptr [9 x i8], [9 x i8]* @holahola, i32 0, i32 0
    store i8* %holahola_ptr, i8** %palabra        ; Cambiar el valor de %palabra a "holahola"

    ret i32 0                                     ; Retornar 0
}
