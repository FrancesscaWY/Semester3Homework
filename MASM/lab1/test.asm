STACKS SEGMENT STACK
    DW 32 DUP(?)
STACKS ENDS

CODES SEGMENT  
    ASSUME CS:CODES,SS:STACKS
START: PUSH DS      
    XOR AX,AX
    MOV DS,AX
    MOV SI,3500H
    MOV CX,8
AA1:MOV [SI],AL
    INC SI
    INC AL
    LOOP AA1

    MOV CX,8
    MOV DI,3600H
    MOV SI,3500H
AA2:MOV [DI],SI
    INC DI
    INC SI
    LOOP AA2
    MOV AX,4C00H
    INT 21H
CODES ENDS
    END START
    