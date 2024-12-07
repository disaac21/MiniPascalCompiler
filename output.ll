@.str1 = private constant [13 x i8] c"Hola, Pascal\00"

define i32 @main() {
    %num = alloca i32
    %letra = alloca i8
    %prueba = alloca i32
    %mensaje = alloca i8*
    %esVerdadero = alloca i1
    store i32 42, i32* %num
    %num_val = load i32, i32* %num
    store i8 65, i8* %letra
    %letra_val = load i8, i8* %letra
    store i8* getelementptr inbounds ([13 x i8], [13 x i8]* @.str1, i32 0, i32 0), i8** %mensaje
    %mensaje_val = load i8*, i8** %mensaje
    store i1 1, i1* %esVerdadero
    %esVerdadero_val = load i1, i1* %esVerdadero
    store i32 34, i32* %num
    %num_val = load i32, i32* %num
    ret i32 0
}
