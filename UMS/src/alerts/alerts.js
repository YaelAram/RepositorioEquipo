import Swal from 'sweetalert2';

export const successAlert = ( title, text ) => {
  Swal.fire( { title, text, icon: 'success', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
};

export const errorAlert = ( title, text ) => {
  Swal.fire( { title, text, icon: 'error', confirmButtonText: 'Ok', confirmButtonColor: "#000" } );
};
