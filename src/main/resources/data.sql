insert into 
    clientes (id, fecha_nacimiento, genero, nombre, primer_apellido, tipo_documento, numero_documento, uuid, created_date, modified_date) 
    values (1001, '1999-11-10', 0, 'Lucho', 'Torres', 'PASAPORTE', '6543210987', '54736e68-cc7f-4449-887c-2cb3efec69ed', '2021-10-01', '2021-11-27');

insert into 
    clientes (id, fecha_nacimiento, genero, nombre, primer_apellido, tipo_documento, numero_documento, uuid, created_date, modified_date) 
    values (1002, '2005-11-5', 1, 'Sara', 'Soliz', 'CI', '5421630', '44736e68-cc7f-4449-887c-2cb3efec6977', '2021-10-01', '2021-11-27');

insert into
    cuentas (id, cliente_id, uuid, tipo_producto, numero_cuenta, moneda, sucursal, fecha_apertura)
    values(2001, 1002, '4449-887c-2cb3efec6977', 'CAJA_AHORRO', '1111000011', 'BS', 'COCHABAMBA', '2010-10-10');
-- insert into
--     cuentas (id, cliente_id, uuid, tipo_producto, numero_cuenta, moneda, sucursal)
--     values(2002, 1002, '36e68-cc7f-444fecabc88', 'CAJA_AHORRO', '1111000012', 'USD', 'COCHABAMBA');