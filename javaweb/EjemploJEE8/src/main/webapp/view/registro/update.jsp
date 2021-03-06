<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jspf"%>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h5><i class="fa fa-edit fa-fw"></i> <b> Update Registro</b></h5> 
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form role="form" action="${appPath}/registro/update" method="POST">
                                <input type="hidden" name="idRegistro" value="${REGISTRO.idRegistro}" />
                                <div class="form-group">
                                    <label for="fechaIngreso">Fecha Ingreso</label>
                                    <input class="form-control" type="date" name="fechaIngreso"  value="${REGISTRO.fechaIngreso}" />
                                </div>     
                                <div class="form-group">
                                    <label for="fehcaSalida">Fehca Salida</label>
                                    <input class="form-control" type="date" name="fehcaSalida"  value="${REGISTRO.fehcaSalida}" />
                                </div>     
                                <div class="form-group">
                                    <label for="cargoIngreso">Cargo Ingreso</label>
                                    <input class="form-control" type="text" name="cargoIngreso"  value="${REGISTRO.cargoIngreso}" />
                                </div>     
                                <div class="form-group">
                                    <label for="descripcionIngreso">Descripcion Ingreso</label>
                                    <input class="form-control" type="text" name="descripcionIngreso"  value="${REGISTRO.descripcionIngreso}" />
                                </div>     
                                <button type="submit" class="btn btn-primary"><i class="fa fa-check fa-fw"></i>Update</button>
                                <a href="${appPath}/registro/list" class="btn btn-default"><i class="fa fa-close fa-fw"></i>Cancel</a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%--end content--%>
<%@ include file="../common/footer.jspf"%>
