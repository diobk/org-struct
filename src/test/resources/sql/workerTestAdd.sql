insert into department (id, name)
    values (10, 'testDepartment');

insert into post (id, name)
    values (10, 'testPost');

insert into worker (id, lastname, name, password, role, department_id, post_id)
    values (10, 'testLastname', 'testName', '$2y$12$CeDWMqvJ.9FX3nP7sfTBR.TRxzO1kwEsSrNEDzFq7vrK6Iypm1Dgu', 'GEN_DIR', 10, 10);

insert into worker (id, lastname, name, password, role, department_id, post_id)
    values (11, 'testLastname', 'testName1', '$2y$12$CeDWMqvJ.9FX3nP7sfTBR.TRxzO1kwEsSrNEDzFq7vrK6Iypm1Dgu', 'WORKER', 10, 10);



