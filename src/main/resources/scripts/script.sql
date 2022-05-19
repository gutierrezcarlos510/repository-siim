select * from view_liquidacion l
inner join satinmus i on i.id = l.id and i.id_inmu = l.id_inmu and i.estado = 1
;

--consulta para ver usuario que no estan eln liquidacion
--select count(*) from satnombr s where s.id not in (select s2.id from satliqin s2);
select inm.id,inm.ant_const ,inm.id_inmu ,max(liq.gestion), case when max(liq.gestion) is null then -1 else (2021-max(liq.gestion)) end faltantes
from satinmus inm
inner join satnombr per on per.id = inm.id
left join satliqin liq on liq.id = inm.id and inm.id_inmu = liq.id_inmu
where inm.estado  = 1
group by inm.id,inm.id_inmu,inm.ant_const;



-- public.view_construccion source

CREATE OR REPLACE VIEW public.view_construccion
AS SELECT c.id,
    c.id_inmu,
    c.id_const,
    c.tp_const,
    c.sup_const,
    c.ant_const,
    c.calidad,
    c.usuario,
    c.estado
   FROM satconst c;


-- public.view_deudor_gestion source

CREATE OR REPLACE VIEW public.view_deudor_gestion
AS SELECT inm.id,
    per.persona,
    per.nombre,
    per.paterno,
    per.materno,
    per.documento,
    per.tipodocum,
    per.zona,
    per.barrio,
    z.descrip AS xzona,
    b.descrip AS xbarrio,
    inm.id_inmu,
        CASE inm.tp_inmu
            WHEN 1 THEN 'Casa'::text
            WHEN 2 THEN 'Terreno'::text
            WHEN 3 THEN 'Depto.'::text
            WHEN 4 THEN 'Prop. Rural'::text
            ELSE ''::text
        END AS xtipo_inmueble,
    max(liq.gestion) AS ultima_gestion
   FROM satinmus inm
     JOIN satnombr per ON per.id::text = inm.id::text
     LEFT JOIN satzonas z ON z.zona::text = per.zona::text
     LEFT JOIN satbarri b ON b.barrio::text = per.barrio::text
     LEFT JOIN satliqin liq ON liq.id::text = inm.id::text AND inm.id_inmu::text = liq.id_inmu::text AND liq.pagado IS NOT NULL AND liq.hora IS NOT NULL
  WHERE inm.estado = 1::numeric
  GROUP BY inm.id, per.persona, per.nombre, per.paterno, per.materno, per.documento, per.tipodocum, per.zona, per.barrio, z.descrip, b.descrip, inm.id_inmu, inm.tp_inmu
  ORDER BY per.paterno, per.materno, per.nombre;


-- public.view_inmueble source

CREATE OR REPLACE VIEW public.view_inmueble
AS SELECT i.id,
    i.id_inmu,
    i.tp_inmu,
    i.censal,
    i.zona,
    i.barrio,
    i.tipocalle,
    i.nombrecall,
    i.numcasa,
    i.bloque,
    i.piso,
    i.numdpto,
    i.catastral,
    i.descrip,
    i.mat_vias,
    i.inclinac,
    i.luz,
    i.agua,
    i.alcantari,
    i.telefono,
    i.superficie,
    i.sup_const,
    i.ant_const,
    i.calidad,
    i.deuda,
    i.exento,
    i.resolucion,
    i.revalor,
    i.sup_ha,
    i.valor_ha,
    i.usuario,
    i.estado,
    i.imchk,
    i.ddrr,
    i.emp_nescri,
    i.emp_fescri,
    i.emp_npoder,
    i.emp_fpoder,
    i.porc,
    i.codluga,
    z.descrip AS xzona,
    b.descrip AS xbarrio,
        CASE i.tipocalle
            WHEN 1 THEN 'Calle'::text
            WHEN 2 THEN 'Plaza'::text
            WHEN 3 THEN 'Avenida'::text
            WHEN 4 THEN 'Pasaje'::text
            ELSE ''::text
        END AS xtipo_calle,
        CASE i.tp_inmu
            WHEN 1 THEN 'Casa'::text
            WHEN 2 THEN 'Terreno'::text
            WHEN 3 THEN 'Depto.'::text
            WHEN 4 THEN 'Prop. Rural'::text
            ELSE ''::text
        END AS xtipo_inmueble,
        CASE i.mat_vias
            WHEN 1 THEN 'Asfalto'::text
            WHEN 2 THEN 'Cemento'::text
            WHEN 3 THEN 'Loseta'::text
            WHEN 4 THEN 'Ripio'::text
            WHEN 5 THEN 'Tierra'::text
            WHEN 6 THEN 'Ladrillo'::text
            WHEN 7 THEN 'Desconocido7'::text
            WHEN 8 THEN 'Desconocido8'::text
            ELSE ''::text
        END AS xmaterialvia,
        CASE i.inclinac
            WHEN 1 THEN 'Economica'::text
            WHEN 2 THEN 'Buena'::text
            WHEN 3 THEN 'Muy buena'::text
            WHEN 4 THEN 'Lujosa'::text
            ELSE ''::text
        END AS xinclinacion
   FROM satinmus i
     LEFT JOIN satzonas z ON i.zona::text = z.zona::text
     LEFT JOIN satbarri b ON i.barrio::text = b.barrio::text;


-- public.view_liquidacion source

CREATE OR REPLACE VIEW public.view_liquidacion
AS SELECT l.persona,
    l.id,
    l.id_inmu,
    l.tp_inmu,
    l.val_tab,
    l.factor,
    l.valor_t,
    l.valcm2,
    l.valor_vi,
    l.fd_an,
    l.base_imp,
    l.imp_neto,
    l.d10,
    l.mant_val,
    l.interes,
    l.mul_mora,
    l.deb_for,
    l.san_adm,
    l.monto,
    l.por_form,
    l.monto_p,
    l.fech_venc,
    l.fech_imp,
    l.fecodo,
    l.cotido,
    l.tp,
    l.descont,
    l.gestion,
    l.credito,
    l.sal_favor,
    l.usuario,
    l.hora,
    l.pagado,
    l.control,
    l.cuota,
    l.cotiufv,
        CASE l.persona
            WHEN 1 THEN 'Persona Natural'::text
            WHEN 2 THEN 'Persona Juridica'::text
            ELSE ''::text
        END AS xtipo_persona,
        CASE l.tp_inmu
            WHEN 1 THEN 'Casa'::text
            WHEN 2 THEN 'Terreno'::text
            WHEN 3 THEN 'Depto.'::text
            WHEN 4 THEN 'Prop. Rural'::text
            ELSE ''::text
        END AS xtipo_inmueble
   FROM satliqin l;


-- public.view_persona source

CREATE OR REPLACE VIEW public.view_persona
AS SELECT p.id,
    p.persona,
    p.documento,
    p.tipodocum,
    p.expedido,
    p.paterno,
    p.materno,
    p.nombre,
    p.ruc,
    p.razon_soc,
    p.zona,
    p.barrio,
    p.tipocalle,
    p.nombrecall,
    p.numcasa,
    p.medidor,
    p.bloque,
    p.piso,
    p.numdpto,
    p.casilla,
    p.telefono,
    p.descrip,
    p.cod_ham,
    p.usuario,
    p.estado,
    p.fecha_nac,
    p.imp,
    p.idnew,
    p.gam,
    p.fec_reg,
        CASE p.tipodocum
            WHEN 1 THEN 'Carnet de identidad'::text
            WHEN 2 THEN 'RUN'::text
            WHEN 3 THEN 'RUC'::text
            WHEN 4 THEN 'Pasaporte'::text
            WHEN 5 THEN 'Cedula extranjera'::text
            ELSE ''::text
        END AS xtipo_documento,
        CASE p.persona
            WHEN 1 THEN 'Persona Natural'::text
            WHEN 2 THEN 'Persona Juridica'::text
            ELSE ''::text
        END AS xtipo_persona,
    z.descrip AS xzona,
    b.descrip AS xbarrio,
        CASE p.tipocalle
            WHEN 1 THEN 'Calle'::text
            WHEN 2 THEN 'Plaza'::text
            WHEN 3 THEN 'Avenida'::text
            WHEN 4 THEN 'Pasaje'::text
            ELSE ''::text
        END AS xtipo_calle
   FROM satnombr p
     LEFT JOIN satzonas z ON p.zona::text = z.zona::text
     LEFT JOIN satbarri b ON p.barrio::text = b.barrio::text;


-- public.view_recaudacion_inmueble source

CREATE OR REPLACE VIEW public.view_recaudacion_inmueble
AS SELECT r.persona,
    r.id,
    r.id_inmu,
    r.tp_inmu,
    r.val_tab,
    r.factor,
    r.valor_t,
    r.valcm2,
    r.valor_vi,
    r.fd_an,
    r.base_imp,
    r.imp_neto,
    r.d10,
    r.mant_val,
    r.interes,
    r.mul_mora,
    r.deb_for,
    r.san_adm,
    r.monto,
    r.por_form,
    r.monto_p,
    r.fech_venc,
    r.fech_imp,
    r.fecodo,
    r.cotido,
    r.tp,
    r.descont,
    r.credito,
    r.gestion,
    r.sal_favor,
    r.usuario,
    r.hora,
    r.fp_origin,
    r.pagado,
    r.control,
    r.cuota,
    r.cotiufv,
        CASE r.tp_inmu
            WHEN 1 THEN 'Casa'::text
            WHEN 2 THEN 'Terreno'::text
            WHEN 3 THEN 'Depto.'::text
            WHEN 4 THEN 'Prop. Rural'::text
            ELSE ''::text
        END AS xtipo_inmueble
   FROM satrecin r;


-- public.view_tramite_orden source

CREATE OR REPLACE VIEW public.view_tramite_orden
AS SELECT s.id,
    s.formulario,
    s.fecha,
    s.hora,
    s.orden,
    s.usuario,
    p.nombre,
    p.paterno,
    p.materno
   FROM sattrol s
     LEFT JOIN satnombr p ON p.id::text = s.id::text;
