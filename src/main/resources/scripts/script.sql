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
group by inm.id,inm.id_inmu,inm.ant_const
