DATA SEGMENT
    PROMPT1 DB "ENTER FIRST NUMBER: $"
    PROMPT2 DB "ENTER SECOND NUMBER: $"
    RESULT_PROMPT_ADD DB "ADDITION RESULT: $"
    RESULT_PROMPT_SUB DB "SUBTRACTION RESULT: $"
    RESULT_PROMPT_MUL DB "MULTIPLICATION RESULT: $"
    RESULT_PROMPT_DIV DB "DIVISION RESULT: $"
    NUMBER1 DW 0
    NUMBER2 DW 0
    RESULT DW 0
    BUFFER DB 6, ?, 5 DUP('$')  ; Buffer for user input
DATA ENDS

SSTACK SEGMENT STACK
    DW 100 DUP(?)
SSTACK ENDS

CODE SEGMENT
    ASSUME CS:CODE, DS:DATA
START:
    MOV AX, DATA
    MOV DS, AX

    LEA DX, PROMPT1
    CALL DISPLAYSTRING
    CALL INPUTNUMBER
    MOV [NUMBER1], AX

    LEA DX, PROMPT2
    CALL DISPLAYSTRING
    CALL INPUTNUMBER
    MOV [NUMBER2], AX

    ; Addition
    CALL ADD_NUMBERS
    LEA DX, RESULT_PROMPT_ADD
    CALL DISPLAYSTRING
    MOV AX, [RESULT]
    CALL DISPLAYNUMBER

    ; Subtraction
    CALL SUBTRACT_NUMBERS
    LEA DX, RESULT_PROMPT_SUB
    CALL DISPLAYSTRING
    MOV AX, [RESULT]
    CALL DISPLAYNUMBER

    ; Multiplication
    CALL MULTIPLY_NUMBERS
    LEA DX, RESULT_PROMPT_MUL
    CALL DISPLAYSTRING
    MOV AX, [RESULT]
    CALL DISPLAYNUMBER

    ; Division
    CALL DIVIDE_NUMBERS
    LEA DX, RESULT_PROMPT_DIV
    CALL DISPLAYSTRING
    MOV AX, [RESULT]
    CALL DISPLAYNUMBER

    MOV AH, 4CH
    INT 21H

; --- Input Number Subroutine ---
INPUTNUMBER PROC
    LEA DX, BUFFER      ; Load address of input buffer
    MOV AH, 0AH         ; DOS function 0AH: buffered input
    INT 21H
    LEA SI, BUFFER + 1  ; Skip the first byte (buffer length)

    ; Clear AX to accumulate the number
    XOR AX, AX          ; Clear AX for storing the result
    MOV CX, 0           ; CX is the digit counter

    ; Process the input characters and convert them to an integer
    NEXT_DIGIT:
    LODSB               ; Load next byte from buffer (input character)
    CMP AL, 13          ; Check for carriage return (Enter key)
    JE DONE_INPUT       ; If Enter (CR) pressed, end input

    SUB AL, '0'         ; Convert ASCII to integer (AL = AL - '0')

    ; Multiply AX by 10 (move previous result one digit left)
    MOV BX, 10
    IMUL BX         ; AX = AX * 10
    ADD  AL          ; Add the current digit to AX (AL already contains the number)

    INC CX              ; Increment digit counter
    JMP NEXT_DIGIT      ; Continue processing next digit

DONE_INPUT:
    RET

    DONE_INPUT:
        RET
INPUTNUMBER ENDP

; --- Display String Subroutine ---
DISPLAYSTRING PROC
    MOV AH, 09H
    INT 21H
    RET
DISPLAYSTRING ENDP

; --- Display Number Subroutine ---
DISPLAYNUMBER PROC
    ; Convert number in AX to ASCII and display it
    MOV BX, 10         ; Set up divisor for decimal conversion
    XOR DX, DX         ; Clear DX (quotient goes here)
    MOV SI, OFFSET BUFFER + 5  ; Set buffer to store result in reverse order

    NEXT_DIGIT:
    DIV BX             ; Divide AX by 10, quotient in AX, remainder in DX
    ADD DL, '0'        ; Convert remainder (digit) to ASCII
    DEC SI
    MOV [SI], DL
    CMP AX, 0
    JNE NEXT_DIGIT

    MOV AH, 09H
    MOV DX, SI         ; Load address of the result string
    INT 21H            ; Display the result
    RET
DISPLAYNUMBER ENDP

; --- Add Numbers Subroutine ---
ADD_NUMBERS PROC
    MOV AX, [NUMBER1]
    ADD AX, [NUMBER2]
    MOV [RESULT], AX
    RET
ADD_NUMBERS ENDP

; --- Subtract Numbers Subroutine ---
SUBTRACT_NUMBERS PROC
    MOV AX, [NUMBER1]
    SUB AX, [NUMBER2]
    MOV [RESULT], AX
    RET
SUBTRACT_NUMBERS ENDP

; --- Multiply Numbers Subroutine ---
MULTIPLY_NUMBERS PROC
    MOV AX, [NUMBER1]
    MOV BX, [NUMBER2]
    IMUL BX            ; Correct use of IMUL: AX = AX * BX
    MOV [RESULT], AX    ; Store the result in RESULT
    RET
MULTIPLY_NUMBERS ENDP

; --- Divide Numbers Subroutine ---
DIVIDE_NUMBERS PROC
    MOV AX, [NUMBER1]
    CWD                      ; Extend AX into DX:AX
    MOV BX, [NUMBER2]
    IDIV BX                  ; Divide DX:AX by BX, result in AX, remainder in DX
    MOV [RESULT], AX         ; Store quotient in RESULT
    RET
DIVIDE_NUMBERS ENDP

CODE ENDS
END START
