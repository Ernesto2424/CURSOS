"use strict";

/* si escribimos variables que no ahn sido
definidas entonces marcara erro
y ademas el modo strict nos ayudara a encontar errores
en nustro código */

let arr = [];

for( let i=0; i<5; ++i ){
arr.push(i);
}

console.log( arr);

for( let i=0; i<5; ++i ){
    console.log( arr[i] );
    }