package org.openmrs.module.insuranceclaims.api.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.openmrs.Concept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class that represents an insurance claim diagnosis.
 * Used to point the reason for creating the claim.
 */
@Entity(name = "iclm.ClaimDiagnosis")
@Table(name = "iclm_claim_diagnosis")
public class InsuranceClaimDiagnosis extends AbstractBaseOpenmrsData {

	private static final long serialVersionUID = 1229077935109398654L;

	@Id
	@GeneratedValue
	@Column(name = "iclm_claim_diagnosis_id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "concept", nullable = false)
	private Concept concept;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "insurance_claim", nullable = false)
	private InsuranceClaim insuranceClaim;

	public InsuranceClaimDiagnosis() {
	}

	/**
	 * Creates the representation of an insurance claim diagnosis
	 *
	 * @param concept        - the related concept object
	 * @param insuranceClaim - the related insurance claim object
	 */
	public InsuranceClaimDiagnosis(Concept concept, InsuranceClaim insuranceClaim) {
		super();
		this.concept = concept;
		this.insuranceClaim = insuranceClaim;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}

	public InsuranceClaim getInsuranceClaim() {
		return insuranceClaim;
	}

	public void setInsuranceClaim(InsuranceClaim insuranceClaim) {
		this.insuranceClaim = insuranceClaim;
	}
}
