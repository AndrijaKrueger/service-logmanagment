package de.xcrossworx.service.logmanagment.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SystemNames")
@NamedQueries({@NamedQuery(name = "SystemName.findAll", query = "select e from SystemName e")})
public class SystemName extends BaseEntity{
}
